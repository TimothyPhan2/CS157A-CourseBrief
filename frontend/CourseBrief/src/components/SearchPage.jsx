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
import TagInput from "./Tags";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';
import "../App.css"; 

const LoginPage = () => {
    const navigate = useNavigate();
  return (
    <section className="section-style">
      <Container className="container-style  py-5">
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column">
            <Col 
              className="d-flex flex-fill justify-content-center align-self-center my-5"
              style={{ height: '12%', width: '60%' }}
            >
              <h1 className="display-4 text-center fw-bold searchtitle" >Search Course</h1>

            </Col>
            <div className="d-flex justify-content-center align-items-center align-self-center m-5 form-container">
              <Col md={5} xl={6} className="text-center text-md-start">
                <Form method="post" data-bs-theme="light">
                  <Row className="mb-4">
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="ProfessorName"
                          placeholder="Profs Name"
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="CourseName"
                          placeholder="Course Name"
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                  </Row>
                  <Col >
                    <Form.Group className="mb-4">
                        <TagInput />
                    </Form.Group>
                    </Col>
                  
                  <div className="d-flex justify-content-center mb-4">
                    <Button
                      type="submit"
                      className="btn-primary shadow button-login"
                    >
                      Search
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

export default LoginPage;