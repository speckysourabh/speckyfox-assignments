"use client";

import { setToken } from "@redux/slice";
import Link from "next/link";
import { useRouter } from "next/navigation";
import React, { useEffect } from "react";
import { BsBookHalf } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";

const Navbar = () => {
  const token = sessionStorage.getItem("token");
  const router = useRouter();
  const dispatch = useDispatch();

  const data = useSelector((data) => data.token);
  console.log(data);

  function handleLogout() {
    sessionStorage.clear();
    router.push("/login");
    dispatch(setToken(null));
  }

  function handleBooksClick() {
    router.push("/books");
  }

  return (
    <div className="navbar-container flex justify-between items-center bg-teal-500 text-white p-5 fixed w-full h-20">
      <Link href={"./"}>
        <div className="logo-container flex justify-center items-center font-bold text-xl">
          <BsBookHalf className="mr-2" />
          <span>Book Store</span>
        </div>
      </Link>
      <div className="nav-items">
        {token ? (
          <ul className="nav-ul flex">
            <li className="mr-7 cursor-pointer">
              <button onClick={handleBooksClick}>Books</button>
            </li>
            <li className="mr-7 cursor-pointer">
              <button onClick={handleLogout}>Logout</button>
            </li>
          </ul>
        ) : (
          <ul className="nav-ul flex">
            <li className="mr-7 cursor-pointer">
              <Link href={"/login"}>Sign In</Link>
            </li>
            <li className="mr-7 cursor-pointer">
              <Link href={"/register"}>Sign Up</Link>
            </li>
          </ul>
        )}
      </div>
    </div>
  );
};

export default Navbar;
