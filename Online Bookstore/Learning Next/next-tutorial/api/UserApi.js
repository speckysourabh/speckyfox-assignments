import { baseUrl } from "@utils/Constant";
import Header from "@utils/Header";
import axios from "axios";

export default class UserApi {
  headers = new Header();

  registerUser(data) {
    return axios.post(
      `${baseUrl}/users/register`,
      data,
      this.headers.basicHeader()
    );
  }

  loginUser(data) {
    return axios.post(
      `${baseUrl}/users/login`,
      data,
      this.headers.basicHeader()
    );
  }
}
