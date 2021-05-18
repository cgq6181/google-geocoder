package com.rest.client.json;

import java.util.List;

public class GeocoderResponse {
    private List<Result> results;
    private String status;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GeocoderResponse{" +
                "results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}
