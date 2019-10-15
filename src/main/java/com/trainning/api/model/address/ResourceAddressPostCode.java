package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ResourceAddressPostCode {
    @Getter
    @Setter
    @JsonProperty("data")
    private Collection<AddressPostCode> content;


    /**
     * Creates a {@link ResourceAddressPostCode} instance content collection.
     *
     * @param content list data
     */
    public ResourceAddressPostCode(Collection<AddressPostCode> content) {
        this.content = content;
    }
}
