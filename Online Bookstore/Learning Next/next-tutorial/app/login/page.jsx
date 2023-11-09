"use client";
import UserApi from "@api/UserApi";
import { setGlobalState, setToken, setTokenSlice } from "@redux/slice";
import MyRole from "@utils/MyRole";
import parseJwt from "@utils/TokenUtils";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { toast, useToast } from "react-toastify";

const defaultFormData = {
  email: "",
  password: "",
};

const LoginPage = () => {
  const [formData, setFormData] = useState(defaultFormData);
  const router = useRouter();
  const dispatch = useDispatch();

  function handleChange(e) {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    e.preventDefault();
    const userApi = new UserApi();
    userApi
      .loginUser(formData)
      .then((response) => {
        sessionStorage.setItem("token", response.data);
        dispatch(setToken(response.data));
        const user = parseJwt(response.data);
        console.log(user);
        if (user.role === MyRole.USER) {
          router.push("/bookstore");
        } else if (user.role === MyRole.ADMIN) {
          router.push("/dashboard");
        }
      })
      .catch((error) => {
        console.log(error);
        toast("User not found");
      });
  }

  return (
    <div className="loginpage-container flex justify-center mt-20">
      <form
        onSubmit={handleSubmit}
        className="border-2 border-lightgray p-10 rounded-lg"
      >
        <div className="form-title text-center text-4xl mb-10 bg-orange-400">
          Sign In
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
        <div className="submit-btn text-center mt-10">
          <button
            type="submit"
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
          >
            Login
          </button>
        </div>
      </form>
    </div>
  );
};

export default LoginPage;
