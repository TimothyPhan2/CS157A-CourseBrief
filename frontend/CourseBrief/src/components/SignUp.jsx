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
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import "../App.css";
const SignUpPage = () => {
  const navigate = useNavigate();
  
  const handleSubmit = (event) => {
    event.preventDefault();
    event.stopPropagation();

    
    const email = event.target.email.value
    const password = event.target.password.value
    const firstName = event.target.FirstName.value
    const lastName = event.target.LastName.value
    if ('' === email) {
      setEmailError('Please enter your email')
      return
    }
  
    if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email)) {
      setEmailError('Please enter a valid email')
      return
    }
  
    if ('' === password) {
      setPasswordError('Please enter a password')
      return
    }
  
    if (password.length < 7) {
      setPasswordError('The password must be 8 characters or longer')
      return
    }
    
    console.log("Form submitted!");
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
                <Form method="post" data-bs-theme="light">
                  <Row className="mb-4">
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="FirstName"
                          placeholder="First Name"
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="LastName"
                          placeholder="Last Name"
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                  </Row>
                  <Form.Group className="mb-4">
                    <FormControl
                      type="email"
                      name="email"
                      placeholder="Email"
                      className="shadow"
                    />
                  </Form.Group>
                  <Form.Group className="mb-4">
                    <FormControl
                      type="password"
                      name="password"
                      placeholder="Password"
                      className="shadow"
                    />
                  </Form.Group>
                  <div className="d-flex justify-content-center mb-4">
                    <Button
                      type="submit"
                      className="btn-primary shadow button-login"
                      onClick={handleSubmit}
                    >
                      Sign Up
                    </Button>
                  </div>
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
