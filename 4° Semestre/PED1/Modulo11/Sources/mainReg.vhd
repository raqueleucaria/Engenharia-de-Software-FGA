LIBRARY ieee ;
USE ieee.std_logic_1164.all ;

ENTITY shift4 IS
    PORT ( R : IN STD_LOGIC_VECTOR(3 DOWNTO 0) ;
           Clock : IN STD_LOGIC ;
           L, w : IN STD_LOGIC ;
           Q : BUFFER STD_LOGIC_VECTOR(3 DOWNTO 0) ) ;
    END shift4 ;

ARCHITECTURE Behavior OF shift4 IS
    BEGIN
    PROCESS
        BEGIN
            WAIT UNTIL Clock'EVENT AND Clock = '1' ;
            IF L = '1' THEN Q <= R ;
                ELSE
                Q(0) <= Q(1) ;
                Q(1) <= Q(2);
                Q(2) <= Q(3) ;
                Q(3) <= w ;
            END IF ;
    END PROCESS ;
END Behavior ;