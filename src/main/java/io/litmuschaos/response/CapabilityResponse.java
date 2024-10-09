package io.litmuschaos.response;

public class CapabilityResponse {
    private Dex dex;

    public Dex getDex() {
        return dex;
    }

    @Override
    public String toString() {
        return "CapabilityResponse{" +
                "dex=" + dex +
                '}';
    }

    public static class Dex {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        @Override
        public String toString() {
            return "Dex{" +
                    "enabled=" + enabled +
                    '}';
        }
    }
}

