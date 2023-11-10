"use client";
import BookApi from "@api/BookApi";
import { useRouter, useSearchParams } from "next/navigation";
import { useEffect, useState } from "react";

const UpdateBookForm = ({ book }) => {
  const [newBook, setNewBook] = useState({
    title: book?.title,
    author: book?.author,
    genre: book?.genre,
  });

  const router = useRouter();
  const params = useSearchParams();
  const bookId = params.get("bookId");

  useEffect(() => {
    const bookApi = new BookApi();
    bookApi
      .getBook(bookId)
      .then((response) => setNewBook(response.data))
      .catch((error) => alert(error));
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewBook({ ...newBook, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const bookApi = new BookApi();
    bookApi
      .updateBook(newBook)
      .then((response) => {
        router.push("/books");
      })
      .catch((error) => {
        alert(error);
      });
  };

  return (
    <div className="flex justify-center">
      <form
        className="max-w-sm rounded overflow-hidden shadow-lg m-4"
        onSubmit={handleSubmit}
      >
        <h1 style={{ textAlign: "center" }} className="p-5">
          Add Book
        </h1>
        <div className="px-6 py-4">
          {/* Title Input */}
          <div className="mb-4">
            <label
              className="block text-gray-700 text-sm font-bold mb-2"
              htmlFor="title"
            >
              Title
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              id="title"
              type="text"
              placeholder="Enter title"
              name="title"
              value={newBook.title}
              onChange={handleInputChange}
              required
            />
          </div>

          {/* Author Input */}
          <div className="mb-4">
            <label
              className="block text-gray-700 text-sm font-bold mb-2"
              htmlFor="author"
            >
              Author
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              id="author"
              type="text"
              placeholder="Enter author"
              name="author"
              value={newBook.author}
              onChange={handleInputChange}
              required
            />
          </div>

          {/* Genre Input */}
          <div className="mb-4">
            <label
              className="block text-gray-700 text-sm font-bold mb-2"
              htmlFor="genre"
            >
              Genre
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              id="genre"
              type="text"
              placeholder="Enter genre"
              name="genre"
              value={newBook.genre}
              onChange={handleInputChange}
              required
            />
          </div>

          {/* Submit Button */}
          <div className="flex items-center justify-between">
            <button
              className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full focus:outline-none focus:shadow-outline"
              type="submit"
            >
              Add Book
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default UpdateBookForm;
