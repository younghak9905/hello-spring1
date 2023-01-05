package domain;

public class Member {
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;

    private String id;

    private Long no;

    private String GitHub;

    private String Blog;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getGitHub() {
    	return GitHub;
    }

    public void setGitHub(String GitHub) {
    	this.GitHub = GitHub;
    }

    public String getBlog() {
    	return Blog;
    }

    public void setBlog(String Blog) {
    	this.Blog = Blog;
    }

    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public Long getNo() {
    	return no;
    }

    public void setNo(Long no) {
    	this.no = no;
    }


}
