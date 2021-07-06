package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

    @Getter
    public class GetUserRequest {
        private final String username;
        private final String password;

        public GetUserRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

