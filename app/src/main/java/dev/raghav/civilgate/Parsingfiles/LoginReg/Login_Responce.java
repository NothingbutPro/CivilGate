package dev.raghav.civilgate.Parsingfiles.LoginReg;

import java.io.File;

public class Login_Responce  {
    Login_user loginUserinfo;
    String ResponceString;

    public Login_Responce(Login_user loginUserinfo, String responceString) {

        this.loginUserinfo = loginUserinfo;
        this.ResponceString = responceString;

    }

    public Login_user getLoginUserinfo() {
        return loginUserinfo;
    }

    public void setLoginUserinfo(Login_user loginUserinfo) {
        this.loginUserinfo = loginUserinfo;
    }

    public String getResponceString() {
        return ResponceString;
    }

    public void setResponceString(String responceString) {
        ResponceString = responceString;
    }

    public class Login_user {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
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

        public String getPassout_year() {
            return passout_year;
        }

        public void setPassout_year(String passout_year) {
            this.passout_year = passout_year;
        }

        public String getCollage_name() {
            return collage_name;
        }

        public void setCollage_name(String collage_name) {
            this.collage_name = collage_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public File getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(File profile_image) {
            this.profile_image = profile_image;
        }

        public File getSign_image() {
            return Sign_image;
        }

        public void setSign_image(File sign_image) {
            Sign_image = sign_image;
        }

        String id , name,mobile,email,password,passout_year,collage_name,address;
        File profile_image , Sign_image;

        public Login_user(String id, String name, String mobile, String email, String password, String passout_year, String collage_name, String address, File profile_image, File sign_image) {
            this.id = id;
            this.name = name;
            this.mobile = mobile;
            this.email = email;
            this.password = password;
            this.passout_year = passout_year;
            this.collage_name = collage_name;
            this.address = address;
            this.profile_image = profile_image;
            Sign_image = sign_image;
        }
    }
}
