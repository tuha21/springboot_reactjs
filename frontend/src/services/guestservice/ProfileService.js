export default {
    updateProfile: (profile) => {
        var myHeaders = new Headers();
        if (localStorage.getItem("token")) {
            myHeaders.append("Authorization", "Bearer " + localStorage.getItem("token"));
            myHeaders.append("Content-Type", "application/json");
            myHeaders.append("Cookie", "JSESSIONID=C6B69B1366935F0C4E7CCAC8732291BA");
        }

        var raw = JSON.stringify({
            username: profile.username,
            fullname: profile.fullName,
            email: profile.email,
            photo: profile.photo,
            status: profile.status,
        });

        var requestOptions = {
            method: "PUT",
            headers: myHeaders,
            body: raw,
            redirect: "follow",
        };

        return fetch("http://localhost:8080/changeProfile", requestOptions);
    },
};
