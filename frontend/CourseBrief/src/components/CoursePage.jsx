import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Form } from "react-bootstrap";
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

  const handleSubmit = (event) => {
    event.preventDefault();
    const user = JSON.parse(localStorage.getItem('user'));
    const userObject = {userID: user.userID}
    const commentbody = {
      textualContent: comment,
      date: getDate(),
      user: userObject,
      course: {courseID: courseId}
    };

    console.log(commentbody);

    axios1
    .post(`/comments`, commentbody)
    .then((response) => {
       console.log(response.data);
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
    <div>
      <h1>CoursePage for course {courseId}</h1>
      <Form method="post" onSubmit={handleSubmit}>
        <Form.Group controlId="commentTextArea">
          <Form.Label>Comment:</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            value={comment}
            onChange={(e) => setComment(e.target.value)}
            style={{ resize: "none" }}
          />
        </Form.Group>
        <input type="submit" value="Submit" />
      </Form>
      <h2>Comments</h2>
      <ul>
        {comments.map((comment, index) => (
          <li key={index}>{comment.textualContent}</li>
        ))}
      </ul>
    </div>
  );
};

export default CoursePage;
