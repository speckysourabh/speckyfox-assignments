import { baseUrl } from "@utils/Constant";
import Header from "@utils/Header";
import axios from "axios";

export default class BookApi {
  headers = new Header();

  getBook(bookId) {
    return axios.get(`${baseUrl}/books/${bookId}`, this.headers.withAuth());
  }

  getAllBook() {
    return axios.get(`${baseUrl}/books`, this.headers.withAuth());
  }

  addBook(data) {
    return axios.post(`${baseUrl}/books`, data, this.headers.withAuth());
  }

  updateBook(data) {
    return axios.put(`${baseUrl}/books`, data, this.headers.withAuth());
  }

  deleteBook(bookId) {
    return axios.delete(`${baseUrl}/books/${bookId}`, this.headers.withAuth());
  }
}
