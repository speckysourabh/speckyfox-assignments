"use client";

import BookApi from "@api/BookApi";
import CartApi from "@api/CartApi";
import BookCard from "@components/BookCard";
import MyRole from "@utils/MyRole";
import parseJwt from "@utils/TokenUtils";
import { useRouter } from "next/navigation";
import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";

const BookPage = () => {
  const [books, setBooks] = useState([]);
  const [cartItems, setCartItems] = useState([]);
  const router = useRouter();
  const token = sessionStorage.getItem("token");
  const user = parseJwt(token);

  useEffect(() => {
    const bookApi = new BookApi();
    bookApi
      .getAllBook()
      .then((response) => {
        setBooks(response.data);
      })
      .catch((error) => {
        toast("Something went wrong !");
      });
  }, []);

  useEffect(() => {
    const cartApi = new CartApi();
    cartApi
      .getUserCart()
      .then((response) => setCartItems(response.data))
      .catch((error) => console.log(error));
  }, []);

  function onUpdate(book) {
    console.log(book);
    router.push(`/update-book?bookId=${book.id}`);
  }

  function onDelete(bookId) {
    const bookApi = new BookApi();
    alert("Disabled Temporarily");
  }

  function addToCart(bookId) {
    const cartApi = new CartApi();
    cartApi
      .addToCart({ bookId: bookId })
      .then((response) => console.log(response))
      .catch((error) => alert(error));
  }

  return (
    <>
      <div className="bg-red-200 p-5 flex justify-end m-5 rounded-lg">
        {user.role === MyRole.ADMIN ? (
          <button onClick={() => router.push("/add-book")}>Add Book</button>
        ) : (
          <button onClick={() => router.push("/add-book")}>
            Cart ({cartItems.length})
          </button>
        )}
      </div>

      <div className="flex justify-center">
        {books.length === 0 ? (
          <h1>No book available</h1>
        ) : (
          books.map((book) => (
            <BookCard
              book={book}
              onUpdate={onUpdate}
              onDelete={onDelete}
              addToCart={addToCart}
            />
          ))
        )}
      </div>
    </>
  );
};

export default BookPage;
