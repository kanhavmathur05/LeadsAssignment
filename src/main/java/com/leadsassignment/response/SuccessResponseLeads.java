package com.leadsassignment.response;

import java.util.List;

public class SuccessResponseLeads {
        private String status = "success";
        private List data;


        public SuccessResponseLeads(String status, List data) {
            this.status = status;
            this.data = data;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List getData() {
            return data;
        }

        public void setData(List data) {
            this.data = data;
        }

}
