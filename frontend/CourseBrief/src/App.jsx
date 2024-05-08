import React, { useState, useContext, useEffect } from "react";

import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './components/Login.jsx';
import SignUpPage from './components/SignUp.jsx';
import LandingPage from "./components/LandingPage.jsx";
import SearchPage from "./components/SearchPage.jsx";
import HomePage from "./components/HomePage.jsx";
import SettingPage from "./components/SettingPage.jsx";
import "./App.css"; 
import NavBar from "./components/NavBar.jsx";
import { AuthContext, AuthProvider} from "./userAuth/AuthContext";

const App = () => {
    return (
      <AuthProvider>
        <RoutesComponent />
      </AuthProvider>
    );
  };
  
  const RoutesComponent = () => {
    const { user } = useContext(AuthContext);
  
    return (
      <>
        <NavBar />
        <Routes>
          {user ? (
            <>
              <Route path="/" element={<LandingPage />} />
              <Route path="homepage" element={<HomePage />} />
              <Route path="search" element={<SearchPage />} />
              <Route path="setting" element={<SettingPage />} />
            </>
          ) : (
            <>
              <Route path="/" element={<LandingPage />} />
              <Route path="login" element={<LoginPage />} />
              <Route path="signup" element={<SignUpPage />} />
            </>
          )}
        </Routes>
      </>
    );
  };
  export default App;