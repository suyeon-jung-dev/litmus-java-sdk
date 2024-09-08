package io.litmuschaos.auth.request;

public class TokenCreateRequest {
    private final String userId;
    private final String name;
    private final Integer daysUntilExpiration;

    private TokenCreateRequest(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.daysUntilExpiration = builder.daysUntilExpiration;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Integer getDaysUntilExpiration() {
        return daysUntilExpiration;
    }

    public static class Builder {
        private String userId;
        private String name;
        private Integer daysUntilExpiration;

        public Builder() {}

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder daysUntilExpiration(Integer daysUntilExpiration) {
            this.daysUntilExpiration = daysUntilExpiration;
            return this;
        }

        public TokenCreateRequest build() {
            return new TokenCreateRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}