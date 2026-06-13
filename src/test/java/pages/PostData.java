package pages;

public class PostData {
    private String postUrl;
    private int likes;
    private int comments;
    private String ownerUsername;

    public PostData(String postUrl, int likes, int comments, String ownerUsername) {
        this.postUrl = postUrl;
        this.likes = likes;
        this.comments = comments;
        this.ownerUsername = ownerUsername;
    }

    // Getters
    public String getPostUrl() {
        return postUrl;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    // Check if post meets engagement criteria
    public boolean meetsEngagementCriteria(int minLikes, int minComments) {
        return this.likes >= minLikes && this.comments >= minComments;
    }

    @Override
    public String toString() {
        return "Likes: " + likes + " | Comments: " + comments + " | Owner: @" + ownerUsername + " | " + postUrl;
    }
}
