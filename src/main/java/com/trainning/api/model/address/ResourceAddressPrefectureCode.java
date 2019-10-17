package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

/**
 * Resource address prefecture code model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ResourceAddressPrefectureCode {
    @Getter
    @Setter
    @JsonProperty("data")
    private Collection<AddressPrefectureCode> data;

    /**
     * Creates a {@link ResourceAddressPrefectureCode} instance content collection.
     *
     * @param data list of {@link AddressPrefectureCode}
     */
    public ResourceAddressPrefectureCode(Collection<AddressPrefectureCode> data) {
        this.data = data;
    }
}
