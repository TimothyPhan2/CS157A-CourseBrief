import React, { useEffect, useState, useRef } from "react";
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
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import "../App.css";
import courseBrief from "../api/axios";
import ResultsPage from "./ResultsPage";
const SearchPage = () => {
  const [tags, setTags] = useState([]);
  const navigate = useNavigate();
  const [profFirstName, setProfFirstName] = useState("");
  const [profLastName, setProfLastName] = useState("");
  const [className, setClassName] = useState("");
  const handleTagsChange = (newTags) => {
    setTags(newTags);
  };

  const handleInputChange = (e, setFunc) => {
    console.log("hello")
    setFunc(e.target.value);
    
  };

  const handleSubmit = (event) => {
    event.preventDefault(); // Prevent the default form submission
    event.stopPropagation(); // Prevent the event from propagating

    const firstName = profFirstName.trim() === "" ? null : profFirstName;
    const lastName = profLastName.trim() === "" ? null : profLastName;
    const classN = className.trim() === "" ? null : className;
    const tagsString = tags.join(',');
    const tagLabel = tagsString === "" ? null : tagsString;

    console.log("Professor First:", firstName);
    console.log("Professor Last:", lastName);
    console.log("Class:", classN);
    console.log("Tags:", tagLabel);

    courseBrief
      .get("/search", {
        params: {
          profFirstName: firstName,
          profLastName: lastName,
          className: classN,
          tagLabel: tagLabel,
        },
      })
      .then((res) => {
        setTags(res.data); // Assuming you want to update the tags state with the response
        console.log(res.data);
        navigate("/results", { state: { data: res.data } });
        
      })
      .catch((err) => {
        console.error("Error:", err);
      });
  };

  return (
    <section className="section-style">
      <Container className="container-style py-5">
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column">
            <Col
              className="d-flex flex-fill justify-content-center align-self-center my-5"
              style={{ height: "12%", width: "60%" }}
            >
              <h1 className="display-4 text-center fw-bold searchtitle">
                Search Course
              </h1>
            </Col>
            <div className="d-flex justify-content-center align-items-center align-self-center m-5 form-container">
              <Col md={5} xl={6} className="text-center text-md-start">
                <Form
                  method="post"
                  data-bs-theme="light"
                  onSubmit={handleSubmit}
                >
                  <Row className="mb-4">
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="ProfessorFirstName"
                          placeholder="Prof First Name"
                          value={profFirstName}
                          onChange={(e) =>
                            handleInputChange(e, setProfFirstName)
                          }
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                    <Col xs={12} md={6}>
                      <Form.Group>
                        <FormControl
                          type="text"
                          name="ProfessorLastName"
                          placeholder="Prof Last Name"
                          value={profLastName}
                          onChange={(e) =>
                            handleInputChange(e, setProfLastName)
                          }
                          className="shadow"
                        />
                      </Form.Group>
                    </Col>
                  </Row>
                  <Col>
                    <Form.Group className="mb-4">
                      <FormControl
                        type="text"
                        name="ClassName"
                        placeholder="Class Name"
                        value={className}
                        onChange={(e) => handleInputChange(e, setClassName)}
                        className="shadow"
                      />
                    </Form.Group>
                  </Col>
                  <Col>
                    <Form.Group className="mb-4">
                      <TagInput onTagsChange={handleTagsChange} />
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

export default SearchPage;
