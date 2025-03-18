import React from 'react';
import Button from '@mui/material/Button';
import styles from './ActionButton.module.css';

interface ActionButtonProps {
  onClick?: () => void;
  text?: string;
}

const ActionButton: React.FC<ActionButtonProps> = ({ 
  onClick,
  text = 'Перейти на сайт'
}) => {
  return (
    <div className={styles.buttonField}>
      <Button 
        className={styles.button}
        onClick={onClick}
        variant="outlined"
      >
        {text}
      </Button>
    </div>
  );
};

export default ActionButton;

