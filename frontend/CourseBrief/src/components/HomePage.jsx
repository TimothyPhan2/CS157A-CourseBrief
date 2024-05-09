import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import HomePageCard from "./HomePageCard";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";

const HomePage = () => {
  // Mock data to hold form data
  const mockData = {
    ProfessorName: "Testing iwth mock data Dr. Smith",
    CourseName: "Computer Science 101",
    Tags: [
      "Algorithms",
      "Data Structures",
      "Programming",
      "Python",
      "Java",
      "C++",
      "C",
      "Computer Science",
    ],
    Comments: [
      "Great course!",
      "Very informative.",
      "Helpful and well-structured.",
      "Good introduction to programming.",
      "Challenging assignments.",
    ],
  };

  return (
    <section className="section-style">
      <Container className="container-style-home py-5" style={{width: "80%;"}}>
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column align-items-center">
            <h1
              className="display-4 text-center fw-bold searchtitle my-5"
              style={{ height: "12%", width: "60%" }}
            >
              Saved Courses
            </h1>
            <div className="card-grid">
              <HomePageCard
                profName={mockData.ProfessorName}
                className={mockData.CourseName}
                tagList={mockData.Tags}
                commentList={mockData.Comments}
              />
              <HomePageCard
                profName={mockData.ProfessorName}
                className={mockData.CourseName}
                tagList={mockData.Tags}
                commentList={mockData.Comments}
              />
              <HomePageCard
                profName={mockData.ProfessorName}
                className={mockData.CourseName}
                tagList={mockData.Tags}
                commentList={mockData.Comments}
              />
              <HomePageCard
                profName={mockData.ProfessorName}
                className={mockData.CourseName}
                tagList={mockData.Tags}
                commentList={mockData.Comments}
              />
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default HomePage;