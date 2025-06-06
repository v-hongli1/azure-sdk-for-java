// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * A value indicating which unit to use.
 */
public final class SplitSkillUnit extends ExpandableStringEnum<SplitSkillUnit> {
    /**
     * The length will be measured by character.
     */
    @Generated
    public static final SplitSkillUnit CHARACTERS = fromString("characters");

    /**
     * The length will be measured by an AzureOpenAI tokenizer from the tiktoken library.
     */
    @Generated
    public static final SplitSkillUnit AZURE_OPEN_AITOKENS = fromString("azureOpenAITokens");

    /**
     * Creates a new instance of SplitSkillUnit value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public SplitSkillUnit() {
    }

    /**
     * Creates or finds a SplitSkillUnit from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SplitSkillUnit.
     */
    @Generated
    public static SplitSkillUnit fromString(String name) {
        return fromString(name, SplitSkillUnit.class);
    }

    /**
     * Gets known SplitSkillUnit values.
     * 
     * @return known SplitSkillUnit values.
     */
    @Generated
    public static Collection<SplitSkillUnit> values() {
        return values(SplitSkillUnit.class);
    }
}
