import React from "react";

import {
  Container,
  Navbar,
  Nav,
  Button,
  Form,
  Row,
  Col,
  FormControl,
} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './components/Login.jsx';
import SignUpPage from './components/SignUp.jsx';
import LandingPage from "./components/LandingPage.jsx";

import "./App.css"; 

const App = () => {
  return (
    <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="login"  element={<LoginPage />} />
          
          <Route path="signup" element={<SignUpPage />} />
      </Routes>

    );
};

export default App;