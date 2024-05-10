import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import HomePageCard from "./HomePageCard";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";

const HomePage = () => {
  // Different sets of mock data for various courses
  const courses = [
    {
      ProfessorName: "Dr. Johnson",
      CourseName: "Algorithms and Complexity",
      Tags: ["Algorithms", "Complexity Theory", "Graphs", "Data Structures"],
      Comments: [
        "Dr. Johnson's explanations are clear and concise.",
        "Challenging assignments but very rewarding.",
        "Highly recommend for anyone interested in algorithms.",
      ],
    },
    {
      ProfessorName: "Prof. Williams",
      CourseName: "Software Engineering",
      Tags: ["Software Design", "Agile", "Scrum", "Project Management"],
      Comments: [
        "Great insights into industry practices.",
        "Enjoyed working in team projects.",
        "The agile methodologies were taught thoroughly.",
      ],
    },
    {
      ProfessorName: "Dr. Smith",
      CourseName: "Database Systems",
      Tags: ["SQL", "Database Design", "NoSQL", "ER Modeling"],
      Comments: [
        "Comprehensive coverage of both SQL and NoSQL databases.",
        "Dr. Smith is very knowledgeable in the field.",
        "The projects were practical and relevant.",
      ],
    },
    {
      ProfessorName: "Prof. Lee",
      CourseName: "Artificial Intelligence",
      Tags: ["AI", "Machine Learning", "Deep Learning", "NLP", "Computer Vision"],
      Comments: [
        "Prof. Lee made the concepts easy to understand.",
        "Loved the hands-on projects with TensorFlow and PyTorch.",
        "A great starting point for anyone interested in AI.",
      ],
    },
  ];

  return (
    <section className="section-style">
      <Container className="container-style-home py-5" style={{ width: "80vw" }}>
        <Row className="d-flex justify-content-center">
          <Col className="d-flex flex-column align-items-center">
            <h1
              className="display-4 text-center fw-bold searchtitle my-5"
              style={{ height: "12%", width: "60%" }}
            >
              Saved Courses
            </h1>
            <div className="card-grid">
              {courses.map((course, index) => (
                <HomePageCard
                  key={index}
                  profName={course.ProfessorName}
                  className={course.CourseName}
                  tagList={course.Tags}
                  commentList={course.Comments}
                />
              ))}
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default HomePage;
