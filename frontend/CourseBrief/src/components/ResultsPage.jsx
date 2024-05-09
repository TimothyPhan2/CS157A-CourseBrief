import React from "react";

import { Container, Button, Row, Col } from "react-bootstrap";

import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import ResultCards from "./ResultCards";

import { useLocation } from "react-router-dom";

const ResultsPage = () => {
  let location = useLocation();
  let data = location.state ? location.state.data : null;
  const courses = [
    { prof: "Prof. Ramin", course: "CS 157A", tags: ["DBMS", "SQL"] },
    { prof: "Prof. Ramin", course: "CS 157A", tags: ["DBMS", "SQL"] },
  ];
  console.log("IN RESULTS PAGE", data);
  return (
    <section className="section-style">
      <Container className="container-style p-5">
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column align-items-center">
            <h1 className="display-4 text-center fw-bold resultstitle">
              Results
            </h1>
            <Row className="d-flex justify-content-center">
              {data.map((courseData, index) => (
                <Col key={index}>
                  <ResultCards
                    prof={courseData.professor.firstName}
                    course={courseData.aclass.className}
                    courseId={courseData.courseID}
                  />
                </Col>
              ))}
            </Row>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default ResultsPage;