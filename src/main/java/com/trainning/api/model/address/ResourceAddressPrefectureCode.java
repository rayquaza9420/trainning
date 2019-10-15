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
public class ResourceAddressPrefectureCode {
    @Getter
    @Setter
    @JsonProperty("data")
    private Collection<AddressPrefectureCode> content;


    /**
     * Creates a {@link ResourceAddressPrefectureCode} instance content collection.
     *
     * @param content list data
     */
    public ResourceAddressPrefectureCode(Collection<AddressPrefectureCode> content) {
        this.content = content;
    }
}
