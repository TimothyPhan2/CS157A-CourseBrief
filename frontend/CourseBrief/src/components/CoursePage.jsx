import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import { Form } from 'react-bootstrap';
import axios1 from "../api/axios";

const CoursePage = () => {
  const { courseId } = useParams();
  const [comment, setComment] = useState('');
  const [comments, setComments] = useState([]);

  // useEffect(() => {
  //   axios1.get(`/courses/${courseId}/comments`)
  //     .then(response => {
  //       setComments(response.data);
  //     })
  //     .catch(error => {
  //       console.error('Error:', error);
  //     });
  // }, [courseId]);

  const handleSubmit = (event) => {
    event.preventDefault();
    axios1.post(`/comments`, { text: comment })
      .then(response => {
        console.log(response.data);
        alert("Comment added successfully");
        setComment(''); // Clear the comment input field
        setComments(prevComments => [...prevComments, response.data]); // Add the new comment to the list
      })
      .catch(error => {
        console.error('Error:', error);
      });
  };

  return (
    <div>
      <h1>CoursePage for course {courseId}</h1>
      <form onSubmit={handleSubmit}>
        <Form.Group controlId="commentTextArea">
          <Form.Label>Comment:</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            value={comment}
            onChange={e => setComment(e.target.value)}
            style={{ resize: 'none' }}
          />
        </Form.Group>
        <input type="submit" value="Submit" />
      </form>
      <h2>Comments</h2>
      <ul>
        {comments.map((comment, index) => (
          <li key={index}>{comment.text}</li>
        ))}
      </ul>
    </div>
  );
};

export default CoursePage;