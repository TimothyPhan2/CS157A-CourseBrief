import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Form, Button, Card, ListGroup, Container, Row, Col } from "react-bootstrap";
import axios1 from "../api/axios";

const CoursePage = () => {
  const { courseId } = useParams();
  const [comment, setComment] = useState("");
  const [comments, setComments] = useState([]);

  // Load comments from localStorage when the component mounts
  useEffect(() => {
    const storedCommentsKey = `comments-${courseId}`;
    const storedComments = localStorage.getItem(storedCommentsKey);
    if (storedComments) {
      setComments(JSON.parse(storedComments));
    }
  }, [courseId]);

  const getDate = () => {
    const today = new Date();
    const month = (today.getMonth() + 1).toString().padStart(2, "0"); // Ensures the month is always two digits
    const year = today.getFullYear();
    const date = today.getDate().toString().padStart(2, "0"); // Ensures the day is always two digits
    return `${year}-${month}-${date}`;
  };

  const formatDate = (isoString) => {
    const date = new Date(isoString);
    const options = { day: "2-digit", month: "long", year: "numeric" };
    return date.toLocaleDateString("en-US", options);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const user = JSON.parse(localStorage.getItem("user"));
    const userObject = { userID: user.userID };
    const commentbody = {
      textualContent: comment,
      date: getDate(),
      user: userObject,
      course: { courseID: courseId },
    };

    axios1
      .post(`/comments`, commentbody)
      .then((response) => {
        alert("Comment added successfully");

        const newComments = [...comments, response.data];
        const storedCommentsKey = `comments-${courseId}`;
        localStorage.setItem(storedCommentsKey, JSON.stringify(newComments));

        setComment("");
        setComments(newComments);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <Container className="my-4">
      <Row>
        <Col>
          <Card className="mb-4" style={{ backgroundColor: "#f8f9fa", padding: "1rem", borderRadius: "8px" }}>
            <h1 style={{ fontSize: "2.5rem", marginBottom: "0.5rem", color: "#333" }}>Course Page for course {courseId}</h1>
          </Card>
        </Col>
      </Row>
      <Row>
        <Col>
          <Card className="mb-4 ">
            <Card.Body>
              <Form method="post" onSubmit={handleSubmit}>
                <Form.Group controlId="commentTextArea">
                  <Form.Label>Leave a Comment:</Form.Label>
                  <Form.Control
                    as="textarea"
                    rows={3}
                    value={comment}
                    onChange={(e) => setComment(e.target.value)}
                    style={{ resize: "none" }}
                    placeholder="Write your comment here..."
                    required
                  />
                </Form.Group>
                <Button type="submit" variant="primary" className="mt-2 search-btn">
                  Submit
                </Button>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Row>
        <Col>
          <h2>Comments</h2>
          <ListGroup variant="flush">
            {comments.length > 0 ? (
              comments.map((comment, index) => (
                <ListGroup.Item key={index}>
                  <Card>
                    <Card.Body>
                      <Card.Text>{comment.textualContent}</Card.Text>
                      <footer className="blockquote-footer">
                        <small>
                          {comment.user.userID} on {formatDate(comment.date)}
                        </small>
                      </footer>
                    </Card.Body>
                  </Card>
                </ListGroup.Item>
              ))
            ) : (
              <ListGroup.Item>
                <Card>
                  <Card.Body>
                    <Card.Text>No comments yet. Be the first to comment!</Card.Text>
                  </Card.Body>
                </Card>
              </ListGroup.Item>
            )}
          </ListGroup>
        </Col>
      </Row>
    </Container>
  );
};

export default CoursePage;
