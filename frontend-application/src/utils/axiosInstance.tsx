import axios from "axios";

const instance = axios.create({
    baseURL: "http://localhost:8181",
    withCredentials: true, // enable CORS
    headers: {
      "Content-Type": "application/json",
      "Referrer-Policy": "no-referrer",
    },
});

export default instance;
