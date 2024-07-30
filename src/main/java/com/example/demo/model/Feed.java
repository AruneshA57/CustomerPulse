package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {
    private Author author;
    private List<Entry> entry;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {
        private Name name;
        private Uri uri;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Name {
            private String label;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Uri {
            private String label;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry {
        private Author author;
        private Updated updated;
        @JsonProperty("im:rating")
        private Rating rating;
        @JsonProperty("im:version")
        private Version version;
        private Id id;
        private Title title;
        private Content content;
        private Link link;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Author {
            private Uri uri;
            private Name name;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Uri {
                private String label;
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Name {
                private String label;
            }
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Updated {
            private String label;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Rating {
            private String label;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Version {
            private String label;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Id {
            private String label;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Title {
            private String label;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Content {
            private String label;
            private Attributes attributes;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Attributes {
                private String type;
            }
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Link {
            private Attributes attributes;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Attributes {
                private String rel;
                private String href;
            }
        }
    }
}