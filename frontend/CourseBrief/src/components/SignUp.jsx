import React, {useRef} from "react";
import axios1 from "../api/axios";
import {
  Container,
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
  const emailRef = useRef();
  const passwordRef = useRef();
  const firstNameRef = useRef();
  const lastNameRef = useRef();
  const usernameRef = useRef();

  const handleSubmit = (event) => {
    event.preventDefault();
    event.stopPropagation();
    
    const user = {
        firstName: firstNameRef.current.value,
        lastName: lastNameRef.current.value,
        email: emailRef.current.value,
        password: passwordRef.current.value,
        username: usernameRef.current.value,
        
    };

    console.log(user);
    
    axios1.post('signup', user)
    .then(response => {
        console.log(response.data);
        alert("User created successfully");
        navigate('/login');
    })
    .catch(error => {
        console.error('Error:', error);
    });

};
  const navigate = useNavigate();
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
                <Form onSubmit={handleSubmit} data-bs-theme="light">
                  <Row className="mb-4">
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="FirstName"
                          placeholder="First Name"
                          ref={firstNameRef}
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
                          ref={lastNameRef}
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                  </Row>
                  <Form.Group className="mb-4">
                    <FormControl
                      type="username"
                      name="username"
                      placeholder="Username"
                      ref={usernameRef}
                      className="shadow"
                    />
                  </Form.Group>
                  <Form.Group className="mb-4">
                    <FormControl
                      type="email"
                      name="email"
                      placeholder="Email"
                      ref={emailRef}
                      className="shadow"
                    />
                  </Form.Group>
                  <Form.Group className="mb-4">
                    <FormControl
                      type="password"
                      name="password"
                      placeholder="Password"
                      ref={passwordRef}
                      className="shadow"
                    />
                  </Form.Group>
                  <div className="d-flex justify-content-center mb-4">
                    <Button
                      type="submit"
                      className="btn-primary shadow button-login"
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