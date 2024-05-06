import React, { useState } from "react";

import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './components/Login.jsx';
import SignUpPage from './components/SignUp.jsx';
import LandingPage from "./components/LandingPage.jsx";
import SearchPage from "./components/SearchPage.jsx";
import Homepage from "./components/HomePage.jsx";
import "./App.css"; 
import NavBar from "./components/NavBar.jsx";

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false)
  
    
  return (
    <>
    
    <NavBar isLoggedIn={isLoggedIn} />
    <Routes>
      
      {isLoggedIn ? (
        <>
        
          <Route path="/" element={<Homepage />} />
          <Route path="search" element={<SearchPage />} />

        </>
      ) : (
        <>
          <Route path="/" element={<LandingPage />} />
          <Route path="login"  element={<LoginPage />} />
          <Route path="signup" element={<SignUpPage />} />
          <Route path="search" element={<SearchPage />} />
        </>
      )}
      
      </Routes>
    </>

    );
};

export default App;