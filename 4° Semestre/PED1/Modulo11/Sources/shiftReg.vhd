library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity shiftReg is
    Port ( sys_clk : in STD_LOGIC;
           clr : in STD_LOGIC;
           d_in : in STD_LOGIC;
           q : out STD_LOGIC_VECTOR (15 downto 0));
end shiftReg;

architecture Behavioral of shiftReg is

    signal d_out, clkint : STD_LOGIC;
    signal data_reg : STD_LOGIC_VECTOR (15 downto 0);        
    component clockDiv
        Port ( clk : in STD_LOGIC;
               clk_div : inout STD_LOGIC);
    end component;

begin

    d_out <= data_reg(15);
    divClock : clockDiv port map (clk => sys_clk, clk_div => clkint);

     process(clkint,clr)  
     begin  
     if (clr = '1') then  
          data_reg <= "0000000000000000";  
     elsif rising_edge(clkint) then  
          data_reg(0) <= d_in;  
          data_reg(1) <= data_reg(0);  
          data_reg(2) <= data_reg(1);
          data_reg(3) <= data_reg(2);
          data_reg(4) <= data_reg(3);
          data_reg(5) <= data_reg(4);
          data_reg(6) <= data_reg(5);
          data_reg(7) <= data_reg(6);
          data_reg(8) <= data_reg(7);
          data_reg(9) <= data_reg(8);
          data_reg(10) <= data_reg(9);
          data_reg(11) <= data_reg(10);
          data_reg(12) <= data_reg(11);
          data_reg(13) <= data_reg(12);
          data_reg(14) <= data_reg(13);
          data_reg(15) <= data_reg(14);
     end if;  
     end process;
    
    q <= data_reg;
end Behavioral;
