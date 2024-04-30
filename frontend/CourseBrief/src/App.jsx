import React from "react";

import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './components/Login.jsx';
import SignUpPage from './components/SignUp.jsx';
import LandingPage from "./components/LandingPage.jsx";
import SearchPage from "./components/SearchPage.jsx";
import "./App.css"; 
import NavBar from "./components/NavBar.jsx";

const App = () => {
  return (
    <>
    <NavBar />
    <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="login"  element={<LoginPage />} />
          
          <Route path="signup" element={<SignUpPage />} />
          <Route path="search" element={<SearchPage />} />
      </Routes>
    </>

    );
};

export default App;