// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.email;

import com.azure.communication.email.implementation.AzureCommunicationEmailServiceImpl;
import com.azure.communication.email.implementation.EmailsImpl;
import com.azure.communication.email.implementation.models.EmailContent;
import com.azure.communication.email.implementation.models.EmailRecipients;
import com.azure.communication.email.models.EmailAddress;
import com.azure.communication.email.models.EmailAttachment;
import com.azure.communication.email.models.EmailMessage;
import com.azure.communication.email.models.EmailSendResult;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.util.Context;
import com.azure.core.util.polling.DefaultPollingStrategy;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.serializer.TypeReference;
import com.azure.core.util.logging.ClientLogger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Initializes a new instance of the asynchronous EmailAsyncClient type. */
@ServiceClient(builder = EmailClientBuilder.class, isAsync = true)
public final class EmailAsyncClient {
    private final EmailsImpl emailServiceClient;
    private final AzureCommunicationEmailServiceImpl serviceClient;

    private static final ClientLogger LOGGER = new ClientLogger(EmailAsyncClient.class);

    /**
     * Initializes an instance of EmailAsyncClient class.
     *
     * @param serviceClient the service client implementation.
     */
    EmailAsyncClient(AzureCommunicationEmailServiceImpl serviceClient) {
        this.serviceClient = serviceClient;
        this.emailServiceClient = serviceClient.getEmails();
    }

    /**
     * Queues an email message to be sent to one or more recipients.
     *
     * @param message Message payload for sending an email.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link PollerFlux} for polling of status of the long running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<EmailSendResult, EmailSendResult> beginSend(EmailMessage message) {
        return beginSend(message, null);
    }

    PollerFlux<EmailSendResult, EmailSendResult> beginSend(EmailMessage message, Context context) {
        Objects.requireNonNull(message, "'message' cannot be null.");
        Objects.requireNonNull(message.getSenderAddress(), "'senderAddress' cannot be null.");
        Objects.requireNonNull(message.getSubject(), "'subject' cannot be null.");

        if (message.getBodyHtml() == null && message.getBodyPlainText() == null) {
            throw LOGGER
                .logExceptionAsError(new NullPointerException("'bodyHtml' and 'bodyPlainText' cannot both be null."));
        }

        if (message.getToRecipients() == null
            && message.getCcRecipients() == null
            && message.getBccRecipients() == null) {
            throw LOGGER.logExceptionAsError(
                new NullPointerException("'toRecipients', 'ccRecipients', and 'bccRecipients' cannot all be null."));
        }

        verifyRecipientEmailAddressesNotNull(message.getToRecipients());
        verifyRecipientEmailAddressesNotNull(message.getCcRecipients());
        verifyRecipientEmailAddressesNotNull(message.getBccRecipients());

        EmailContent content = new EmailContent(message.getSubject()).setHtml(message.getBodyHtml())
            .setPlainText(message.getBodyPlainText());

        EmailRecipients recipients = new EmailRecipients().setTo(message.getToRecipients())
            .setCc(message.getCcRecipients())
            .setBCC(message.getBccRecipients());

        List<com.azure.communication.email.implementation.models.EmailAttachment> attachmentsImpl = null;

        if (message.getAttachments() != null) {
            attachmentsImpl = new ArrayList<>();
            for (EmailAttachment attachment : message.getAttachments()) {
                com.azure.communication.email.implementation.models.EmailAttachment attachmentImpl = null;

                attachmentImpl = new com.azure.communication.email.implementation.models.EmailAttachment(
                    attachment.getName(), attachment.getContentType(), attachment.getContentInBase64());

                String contentId = attachment.getContentId();

                if (contentId != null) {
                    attachmentImpl.setContentId(contentId);
                }

                attachmentsImpl.add(attachmentImpl);
            }
        }

        com.azure.communication.email.implementation.models.EmailMessage messageImpl
            = new com.azure.communication.email.implementation.models.EmailMessage(message.getSenderAddress(), content,
                recipients);

        messageImpl.setHeaders(message.getHeaders())
            .setAttachments(attachmentsImpl)
            .setReplyTo(message.getReplyTo())
            .setUserEngagementTrackingDisabled(message.isUserEngagementTrackingDisabled());

        return PollerFlux.create(Duration.ofSeconds(1),
            () -> emailServiceClient.sendWithResponseAsync(messageImpl, null, null, context),
            new DefaultPollingStrategy<>(this.serviceClient.getHttpPipeline(),
                "{endpoint}".replace("{endpoint}", this.serviceClient.getEndpoint()), null, context),
            TypeReference.createInstance(EmailSendResult.class), TypeReference.createInstance(EmailSendResult.class));
    }

    /**
     * Creates a poller from an existing operation id.
     *
     * @param operationId The operation id of a previous send email operation.
     * @return A poller that can be used to poll for the status of the email.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<EmailSendResult, EmailSendResult> beginSend(String operationId) {
        return beginSend(operationId, null);
    }

    PollerFlux<EmailSendResult, EmailSendResult> beginSend(String operationId, Context context) {
        return PollerFlux.create(Duration.ofSeconds(1),
            () -> emailServiceClient.getSendResultWithResponseAsync(operationId),
            new DefaultPollingStrategy<>(this.serviceClient.getHttpPipeline(),
                "{endpoint}".replace("{endpoint}", this.serviceClient.getEndpoint()), null, context),
            TypeReference.createInstance(EmailSendResult.class), TypeReference.createInstance(EmailSendResult.class));
    }

    void verifyRecipientEmailAddressesNotNull(List<EmailAddress> recipients) {
        if (recipients != null) {
            for (EmailAddress recipient : recipients) {
                Objects.requireNonNull(recipient, "recipient 'EmailAddress' cannot be null.");
                Objects.requireNonNull(recipient.getAddress(), "EmailAddress 'address' cannot be null.");
            }
        }
    }
}
