package io.forcesoftware.models.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskData {

    private String id;
    private String url;
    private String profileAlias;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getProfileAlias() {
        return profileAlias;
    }

    public static class Builder {

        private TaskData taskData;

        public Builder() {
            this.taskData = new TaskData();
        }

        public Builder(TaskData taskData) {
            this.taskData = taskData;
        }

        public Builder id(String id) {
            taskData.setId(id);
            return this;
        }

        public Builder url(String url) {
            taskData.setUrl(url);
            return this;
        }

        public Builder profileAlias(String profileAlias) {
            taskData.setProfileAlias(profileAlias);
            return this;
        }

        public TaskData builder() {
            return taskData;
        }
    }
}
