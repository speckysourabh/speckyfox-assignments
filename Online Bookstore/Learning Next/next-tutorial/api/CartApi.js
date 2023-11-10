import { baseUrl } from "@utils/Constant";
import Header from "@utils/Header";
import axios from "axios";

export default class CartApi {
  headers = new Header();

  addToCart(data) {
    return axios.post(`${baseUrl}/carts`, data, this.headers.withAuth());
  }

  getUserCart() {
    return axios.get(`${baseUrl}/carts/getItems`, this.headers.withAuth());
  }
}
