package com.example.demo.database.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerModel{
        @JsonProperty("id")
        private Long id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("email")
        private String email;

        @Override
        public boolean equals(Object o) {

            if (!(o instanceof CustomerModel)) {
                return false;
            }

            if (this.id == ((CustomerModel) o).getId()) {
                return true;
            }
            return false;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
}