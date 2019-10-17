package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

/**
 * Resource address post code model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ResourceAddressPostCode {
    @Getter
    @Setter
    @JsonProperty("data")
    private Collection<AddressPostCode> data;

    /**
     * Creates a {@link ResourceAddressPostCode} instance content collection.
     *
     * @param data list of {@link AddressPostCode}
     */
    public ResourceAddressPostCode(Collection<AddressPostCode> data) {
        this.data = data;
    }
}
