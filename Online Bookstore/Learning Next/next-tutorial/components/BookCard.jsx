import MyRole from "@utils/MyRole";
import parseJwt from "@utils/TokenUtils";
import React from "react";

const BookCard = ({ book, onUpdate, onDelete, addToCart }) => {
  const token = sessionStorage.getItem("token");
  const user = parseJwt(token);

  return (
    <div className="max-w-sm rounded overflow-hidden shadow-lg m-4">
      <div className="px-6 py-4">
        <div className="font-bold text-xl mb-2">{book.title}</div>
        <p className="text-gray-700 text-base">Author: {book.author}</p>
        <p className="text-gray-700 text-base">Genre: {book.genre}</p>
      </div>
      {user.role == MyRole.USER && (
        <button
          onClick={() => addToCart(book.id)}
          className="bg-amber-500 rounded-sm p-2 m-1"
        >
          Add To Cart
        </button>
      )}

      {user.role == MyRole.ADMIN && (
        <div className="flex justify-between px-6 py-4">
          <button
            className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded-full"
            onClick={() => onUpdate(book)}
          >
            Update
          </button>

          <button
            className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full"
            onClick={() => onDelete(book.id)}
          >
            Delete
          </button>
        </div>
      )}
    </div>
  );
};

export default BookCard;
