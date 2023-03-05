library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity MainMux is
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           b : in STD_LOGIC_VECTOR (3 downto 0);
           c : in STD_LOGIC_VECTOR (3 downto 0);
           clk : in STD_LOGIC;
           an : out STD_LOGIC_VECTOR (3 downto 0);
           seg : out STD_LOGIC_VECTOR (6 downto 0);
           dp : out STD_LOGIC);
end MainMux;

architecture Behavioral of MainMux is

    component BCD_7SEG
        Port ( bcdIn : in STD_LOGIC_VECTOR (3 downto 0);
               S : out STD_LOGIC_VECTOR (6 downto 0));
    end component;
    
    signal clk_div : STD_LOGIC; 
    signal counter : integer range 1 to 100_000 := 1;
    signal seletor : integer range 1 to 4 := 1;
    signal s_an, bcd_now : STD_LOGIC_VECTOR (3 downto 0);
begin

    -----Divisor de clock-----
    
    divisor_clk : process(clk)
    
    begin
    
        if rising_edge(clk) then
            
            if counter = 100_000 then
                
                counter  <= 1;
                clk_div <= not clk_div;
            else 
            
                counter <= counter + 1;
                    
            end if;          
        end if;
    end process;
    
    -----------Multiplex--------------
    
    mux : process(clk_div)
    
    begin
    
        if rising_edge(clk_div) then
        
            case seletor is
            
                when 1 => s_an <= "1110"; bcd_now <= a;
                when 2 => s_an <= "1101"; bcd_now <= b;
                when 3 => s_an <= "0111"; bcd_now <= c;
                when others => s_an <= "1111";
                
            end case;
            seletor <= seletor + 1;
        
        end if;  
    end process;

    an <= s_an;
    dr_bcd: BCD_7SEG port map (bcdIn => bcd_now, S => seg);
    dp <= '1';
    
end Behavioral;
