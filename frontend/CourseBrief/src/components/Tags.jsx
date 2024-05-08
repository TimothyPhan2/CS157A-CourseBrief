import React, { useState, useEffect } from 'react';
import { Form, Badge } from 'react-bootstrap';
import { BsXCircleFill } from 'react-icons/bs'; // Using react-icons for a more styled 'X'
import 'bootstrap/dist/css/bootstrap.min.css';
import "../App.css";
const TagInput = ({onTagsChange}) => {
    const [tags, setTags] = useState([]);
    const [input, setInput] = useState('');

    useEffect(() => {
        onTagsChange(tags);
    }, [tags]);
    const handleKeyDown = (event) => {
        if (event.key === 'Enter' && input) {
            event.preventDefault();
            if (!tags.includes(input)) {
                setTags([...tags, input]);
                setInput('');
            }
        }
    };

    const removeTag = (tagToRemove) => {
        setTags(tags.filter(tag => tag !== tagToRemove));
    };

    return (
        <div>
            <Form.Control
                type="text"
                value={input}
                onChange={(e) => setInput(e.target.value)}
                onKeyDown={handleKeyDown}
                placeholder="Enter course tags"
            />
            <div className="mt-2  d-flex flex-wrap">
                {tags.map((tag, index) => (
                    <Badge pill  key={index} className="me-2 mb-2 d-flex align-items-center tag-badge" style={{ whiteSpace: 'nowrap' }}>
                        {tag}
                        <BsXCircleFill className="ms-2" style={{ cursor: 'pointer' }} onClick={() => removeTag(tag)} />
                    </Badge>
                    
                ))}
            </div>
        </div>
    );
};

export default TagInput;
