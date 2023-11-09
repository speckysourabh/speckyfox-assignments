import Navbar from "@components/Navbar";
import ReduxProvider from "@redux/providers";
import { store } from "@redux/store";
import "@styles/globals.css";
import { Provider } from "react-redux";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export const metadata = {
  title: "Next Tutorial",
  description: "Exploring next js power in the web development",
};

const layout = ({ children }) => {
  return (
    <ReduxProvider>
      <html lang="en">
        <body>
          <Navbar />
          <main
            className="absolute top-20 w-full bg-red-50"
            style={{ fontWeight: "bold", height: "calc(100vh - 80px)" }}
          >
            {children}
          </main>
          <ToastContainer />
        </body>
      </html>
    </ReduxProvider>
  );
};

export default layout;
