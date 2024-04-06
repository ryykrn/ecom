import axios from "axios";

async function saveUser(body){
    return axios.post("/api/v1/users", body);
}

export {
    saveUser
};