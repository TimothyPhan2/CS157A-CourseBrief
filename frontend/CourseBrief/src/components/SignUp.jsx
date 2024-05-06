import React, {useRef} from "react";

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
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import "../App.css";
const SignUpPage = () => {
  const navigate = useNavigate();
  const emailRef = useRef();
  const passwordRef = useRef();
  const handleSubmit = (event) => {
    event.preventDefault();
    event.stopPropagation();

    const email = event.target.email.value;
    const password = event.target.password.value;
    
    const user = {
      
      email: email,
      password: password,
      
    };

    axios.post('http://localhost:8080/signup', user)
    .then(response => {
        console.log(response.data);
        // Navigate to another page after successful signup
        navigate('/some/path');
    })
    .catch(error => {
        console.error('Error:', error);
    });
  };
  return (
    <section className="section-style">
      <Container className="container-style  py-5">
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column">
            <Col
              className="d-flex flex-fill justify-content-center align-self-center my-5"
              style={{ height: "12%", width: "60%" }}
            >
              <Button
                className="btn-primary flex-fill btn-hover button-signin"
                type="button"
                onClick={() => navigate("/login")}
              >
                Sign In
              </Button>
              <Button
                className="btn-primary flex-fill btn-hover button-signup"
                type="button"
               
              >
                Sign Up
              </Button>
            </Col>
            <div className="d-flex justify-content-center align-items-center align-self-center m-5 form-container">
              <Col md={5} xl={6} className="text-center text-md-start">
              <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-4">
        <FormControl
          type="email"
          name="email"
          placeholder="Email"
          className="shadow"
          ref={emailRef}  // Bind the ref to the form field
        />
      </Form.Group>
      <Form.Group className="mb-4">
        <FormControl
          type="password"
          name="password"
          placeholder="Password"
          className="shadow"
          ref={passwordRef}  // Bind the ref to the form field
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
              </Col>
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default SignUpPage;
