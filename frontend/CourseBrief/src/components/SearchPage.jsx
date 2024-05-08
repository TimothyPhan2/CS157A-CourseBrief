import React, { useEffect, useState, useRef} from 'react';
import { Container, Navbar, Nav, Button, Form, Row, Col, FormControl } from 'react-bootstrap';
import TagInput from './Tags';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';
import '../App.css';
import courseBrief from "../api/axios";
const SearchPage = () => {
    const [tags, setTags] = useState([]);
    const classNameRef = useRef(null);
    const firstNameRef = useRef(null);
    const lastNameRef = useRef(null);

    const handleTagsChange = (newTags) => {
        setTags(newTags);
    };
    const handleSubmit = (event) => {
        
        event.preventDefault();  // Prevent the default form submission
        event.stopPropagation(); // Prevent the event from propagating
        const tagLabel = tags.join(', ');
        console.log('Professor First:', firstNameRef.current.value);
        console.log('Professor Last:', lastNameRef.current.value);
        console.log('Class:', classNameRef.current.value);
        console.log('Tags:', (tagLabel));
        
        courseBrief.get("/search", {
            params: {
                profFirstName: firstNameRef.current.value,
                profLastName: lastNameRef.current.value,
                className: classNameRef.current.value,
                tagLabel: tagLabel,
            }
        }).then(res => {
            setTags(res.data); // Assuming you want to update the tags state with the response
            console.log(res.data);
        }).catch(err => {
            console.error("Error:", err);
        });
    };

    return (
        <section className='section-style'>
            <Container className='container-style py-5'>
                <Row className='d-flex justify-content-center'>
                    <Col className='d-flex flex-column'>
                        <Col
                            className='d-flex flex-fill justify-content-center align-self-center my-5'
                            style={{ height: '12%', width: '60%' }}>
                            <h1 className='display-4 text-center fw-bold searchtitle'>Search Course</h1>
                        </Col>
                        <div className='d-flex justify-content-center align-items-center align-self-center m-5 form-container'>
                            <Col md={5} xl={6} className='text-center text-md-start'>
                                <Form method='post' data-bs-theme='light' onSubmit={handleSubmit}>
                                    <Row className='mb-4'>
                                        <Col xs={12} md={6}>
                                            <Form.Group>
                                                <FormControl
                                                    type='text'
                                                    name='ProfessorFirstName'
                                                    placeholder='Prof First Name'
                                                    ref={firstNameRef}
                                                    className='shadow'
                                                />
                                            </Form.Group>
                                            
                                        </Col>
                                        <Col xs={12} md={6}>
                                            <Form.Group>
                                                <FormControl
                                                    type='text'
                                                    name='ProfessorLastName'
                                                    placeholder='Prof Last Name'
                                                    ref={lastNameRef}
                                                    className='shadow'
                                                />
                                            </Form.Group>
                                            
                                        </Col>
                                    </Row>
                                    <Col>
                                    <Form.Group className='mb-4'>
                                                <FormControl
                                                    type='text'
                                                    name='ClassName'
                                                    placeholder='Class Name'
                                                    ref={classNameRef}
                                                    className='shadow'
                                                />
                                            </Form.Group>
                                    </Col>
                                    <Col>
                                        <Form.Group className='mb-4'>
                                            <TagInput onTagsChange={handleTagsChange} />
                                        </Form.Group>
                                    </Col>

                                    <div className='d-flex justify-content-center mb-4'>
                                        <Button type='submit' className='btn-primary shadow button-login'>
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
