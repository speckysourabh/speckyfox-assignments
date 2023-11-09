"use client";

import BookApi from "@api/BookApi";
import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";

const BookPage = () => {
  const [books, setBooks] = useState([]);

  console.log(books);

  useEffect(() => {
    const bookApi = new BookApi();
    bookApi
      .getAllBook()
      .then((response) => {
        setBooks(response.data);
      })
      .catch((error) => {
        //toast("Something went wrong !");
      });
  }, []);

  return (
    <div className="flex justify-center">
      {books.length === 0 ? (
        <h1>No book available</h1>
      ) : (
        books.map((book) => <p>{book.title}</p>)
      )}
    </div>
  );
};

export default BookPage;
