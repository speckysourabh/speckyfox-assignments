import { baseUrl } from "@utils/Constant";
import Header from "@utils/Header";
import axios from "axios";

export default class BookApi {
  headers = new Header();

  getAllBook() {
    return axios.get(`${baseUrl}/books/getAll`, this.headers.withAuth());
  }
}
