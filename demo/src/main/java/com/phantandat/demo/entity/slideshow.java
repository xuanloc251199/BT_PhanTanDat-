package com.phantandat.demo.entity;

import java.io.IOException;
import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Converter(autoApply = true)
class JsonbConverter implements AttributeConverter<JsonNode, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(JsonNode attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (final IOException e) {
            throw new RuntimeException("JSON writing error", e);
        }
    }

    @Override
    public JsonNode convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readTree(dbData);
        } catch (final IOException e) {
            return null;
        }
    }
}

@Entity
@Table(name = "slideshow")
public class slideshow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 80)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String destinationUrl;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String image;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String placeholder;

    @Column(length = 160)
    private String description;

    @Column(length = 50)
    private String btnLabel;

    @Column(nullable = false)
    private Integer displayOrder;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean published;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer clicks;

    @Convert(converter = JsonbConverter.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode styles;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private staff_accounts createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private staff_accounts updatedBy;

}
