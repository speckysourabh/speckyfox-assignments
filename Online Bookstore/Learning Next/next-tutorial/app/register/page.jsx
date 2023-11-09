"use client";

import UserApi from "@api/UserApi";
import MyRole from "@utils/MyRole";
import React, { useState } from "react";
import { useSelector } from "react-redux";

const defaultFormData = {
  email: "",
  password: "",
  confirmPassword: "",
  role: MyRole.USER,
};

const RegisterPage = () => {
  const [formData, setFormData] = useState(defaultFormData);
  const email = useSelector((data) => data.users);
  console.log(email);

  function handleChange(e) {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    e.preventDefault();
    const userApi = new UserApi();
    userApi
      .registerUser(formData)
      .then((response) => console.log(response.data))
      .catch((error) => alert(error));
  }
  return (
    <div className="loginpage-container flex justify-center mt-20">
      <form
        onSubmit={handleSubmit}
        className="border-2 border-lightgray p-10 rounded-lg"
      >
        <div className="form-title text-center text-4xl mb-10 bg-orange-400">
          Sign Up
        </div>
        <div className="email-field">
          <input
            type="email"
            name="email"
            placeholder="Enter your email"
            value={formData.email}
            onChange={handleChange}
            className="px-5 py-3 outline-none rounded-md mb-5"
          />
        </div>
        <div className="password-field">
          <input
            type="password"
            name="password"
            placeholder="Enter your password"
            value={formData.password}
            onChange={handleChange}
            className="px-5 py-3 outline-none rounded-md mb-5"
          />
        </div>
        <div className="confirm-password-field">
          <input
            type="password"
            name="confirmPassword"
            placeholder="Enter confirm password"
            value={formData.confirmPassword}
            onChange={handleChange}
            className="px-5 py-3 outline-none rounded-md mb-5"
          />
        </div>
        <div className="submit-btn text-center mt-10">
          <button
            type="submit"
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
          >
            Register
          </button>
        </div>
      </form>
    </div>
  );
};

export default RegisterPage;
